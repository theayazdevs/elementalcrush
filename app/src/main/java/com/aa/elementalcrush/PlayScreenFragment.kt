package com.aa.elementalcrush

import android.app.AlertDialog
import android.content.Context
import android.content.res.Resources
import android.graphics.Rect
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.aa.elementalcrush.databinding.FragmentPlayScreenBinding

//this is the main game class which handles all the game logic
class PlayScreenFragment : Fragment() {
    //class properties
    //Fragment binding with the play screen to access the elements on the XML layout
    private lateinit var playBinding : FragmentPlayScreenBinding
    //property to store the SensorManager class which allows access to the device's sensors
    private lateinit var sensorManager: SensorManager
    //this property will store the accelerometer sensor of the device
    private lateinit var accelerometer: Sensor
    //the text view that dynamically changes to the next question
    private lateinit var questionHolder: TextView
    //image views for the car and both answers visible on screen
    private lateinit var car: ImageView
    private lateinit var answerOneImage: ImageView
    private lateinit var answerTwoImage: ImageView
    //navigation controller to manage navigation between different game destinations
    private lateinit var navController: NavController
    //score and current question index update with each question, +1 if correct and back to default 0 if game over
    private var currentGameScore = 0
    private var indxCrntQstn = 0
    //to stop the game when game is over and continue when correct answer given
    private var isGameOver = false
    private var crctAns = false
    //stores the current question and its answers taken from the Question class
    private var crntQstn: Question? = null
    //declaring audio variables
    private lateinit var carAudio: MediaPlayer
    private lateinit var wrongAnsAudio: MediaPlayer
    private lateinit var correctAnsAudio: MediaPlayer
    //to store an instance of QuestionAnswers class
    private lateinit var questionAnswers: QuestionAnswers
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //initializing Fragment variables as declared in the above properties
        navController = findNavController()
        car = playBinding.car
        answerOneImage = playBinding.answerOne
        answerTwoImage = playBinding.answerTwo
        questionHolder = playBinding.questionTextView
        questionAnswers = QuestionAnswers()
        //crntQstn = questions[indxCrntQstn]
        crntQstn = questionAnswers.questions[indxCrntQstn]
        //initializing sensor
        sensorManager = requireActivity().getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        //initializing audio for the game
        carAudio = MediaPlayer.create(requireActivity(), R.raw.jet)
        wrongAnsAudio = MediaPlayer.create(requireActivity(), R.raw.wrong)
        correctAnsAudio = MediaPlayer.create(requireActivity(), R.raw.correct)
        //Show the question and possible answers on the screen
        setGame()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_play_screen, container, false)
        //inflates the layout and creates the view
        playBinding = FragmentPlayScreenBinding.inflate(inflater, container, false)
        return playBinding.root
    }
    //this method sets up the game by setting the question and possible answers, uses getDrawable of Question class to get image resources
    private fun setGame() {
        //start the car audio
        carAudio.start()
        //set the current question
        crntQstn = questionAnswers.questions[indxCrntQstn]
        //display current question in the text view
        questionHolder.text = crntQstn?.questionTxt
        //questionHolder.text = "Testing"
        //get answers related to the question and display the relevant images
        val answers = crntQstn?.answers ?: return
        answerOneImage.setImageResource(questionAnswers.getDrawable(answers[0]))
        answerTwoImage.setImageResource(questionAnswers.getDrawable(answers[1]))
        answerOneImage.setTag(R.id.answerOne, answers[0])
        answerTwoImage.setTag(R.id.answerTwo, answers[1])
        //(questionHolder.text as String?)?.let { Log.d("cba", it) }
        /*
        Log.d("edcba", answers[0])
        Log.d("edcba", answers[1])
        */
    }

    override fun onResume() {
        super.onResume()
        //reporting sensor data with the set accuracy
        //sensorManager?.registerListener(sensorEventListener, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
        //sensorManager?.registerListener(sensorEventListener, accelerometer, SensorManager.SENSOR_DELAY_FASTEST)
        //sensorManager.registerListener(sensorEventListener, accelerometer, SensorManager.SENSOR_STATUS_ACCURACY_HIGH)
        //sensorManager.registerListener(sensorEventListener, accelerometer, SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM)
        sensorManager.registerListener(sensorEventListener, accelerometer, SensorManager.SENSOR_STATUS_ACCURACY_LOW)
    }
    override fun onPause() {
        super.onPause()
        //unregister the sensor event listener
        sensorManager?.unregisterListener(sensorEventListener)
    }
    //receiving sensor data whenever there is new data
    private val sensorEventListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

        override fun onSensorChanged(event: SensorEvent?) {
            //if its game over or correct answer given stop the game to show the relevant alert boxes
            if (event == null || isGameOver || crctAns) {
                //sensorManager.unregisterListener(sensorEventListener)
                return
            }
            else{
                /*
                val x = event.values[0]
                val y = event.values[1]
                val z = event.values[2]
                */
                //x and y values data from the sensor
                val x = event.values[0]
                val y = event.values[1]*4
                //the width and height of the device's screen in pixels
                val playScreenWidth = Resources.getSystem().displayMetrics.widthPixels
                val playScreenHeight = Resources.getSystem().displayMetrics.heightPixels
                // left, top, right, bottom position of the car on the screen
                val carLeft = car.left - x
                val carTop = car.top + y
                val carRight = car.right - x
                val carBottom = car.bottom + y
                //to check if the car is within the bounds of the screen while moving the car left and right
                if (carLeft > 0 && carRight < playScreenWidth) {
                    car.offsetLeftAndRight(-x.toInt())
                }
                //to check if the car is within the bounds of the screen while moving the car top and bottom
                if (carTop > 0 && carBottom < playScreenHeight) {
                    car.offsetTopAndBottom(y.toInt())
                }
                /*var myText = "%.2f".format(x) + " %.2f".format(y) + " %.2f".format(z)
                Log.d("MyTAG",myText)*/
                //this checks if the element was hit by the car
                elementCrushed()
            }
            //}
        }
        //this method checks if the player has hit the correct or wrong element and calls the appropriate alert box
        private fun elementCrushed() {
            //holds the locations of the car and the two answers on the screen as an integer array with the size to hold 3 locations
            val rectLocHolder = IntArray(2)
            //car location on the screen
            car.getLocationInWindow(rectLocHolder)
            val theCar = Rect(
                rectLocHolder[0], rectLocHolder[1],
               rectLocHolder[0] + car.width, rectLocHolder[1] + car.height
            )
            //answer one location on the screen
            answerOneImage.getLocationInWindow(rectLocHolder)
            val ansOne = Rect(
                rectLocHolder[0], rectLocHolder[1],
                rectLocHolder[0] + answerOneImage.width, rectLocHolder[1] + answerOneImage.height
            )
            //answer two location on the screen
            answerTwoImage.getLocationInWindow(rectLocHolder)
            val ansTwo = Rect(
                rectLocHolder[0], rectLocHolder[1],
                rectLocHolder[0] + answerTwoImage.width, rectLocHolder[1] + answerTwoImage.height
            )
            //getting names of the image files using their tags to be shown in the alert box
            val imageViewOne: ImageView = answerOneImage
            val imageViewTwo: ImageView = answerTwoImage
            //storing image file name as a string
            val imageFileNameOne = imageViewOne.getTag(R.id.answerOne) as String
            val imageFileNameTwo = imageViewTwo.getTag(R.id.answerTwo) as String
            //crntQstn?.correctAnswer?.let { Log.d("crctAns", it) }
            //if car intersects with the answer one, then call correct or wrong answer methods respectively
            if (Rect.intersects(theCar, ansOne) ) {
                //answerOneImage.setImageResource(R.drawable.atom)
                //when this element is hit show this image
                answerOneImage.setImageResource(R.drawable.hit)
                //Log.d("intersect", imageFileNameOne)
                //check if the image hit was the right answer or wrong
                if(crntQstn?.correctAnswer != imageFileNameOne){
                    Log.d("intersect", "Intersected1")
                    isGameOver = true
                    //hitWrongAnswer()
                    hitWrongAnswer(imageFileNameOne)
                }
                else {
                    currentGameScore++
                    crctAns = true
                    hitCorrectAnswer(imageFileNameOne)
                }
            }
            else if (Rect.intersects(theCar, ansTwo)) {
                //answerTwoImage.setImageResource(R.drawable.atom)
                //when this element is hit show this image
                answerTwoImage.setImageResource(R.drawable.hit)
                //Log.d("intersect", imageFileNameTwo)
                //check if the image hit was the right answer or wrong
                if(crntQstn?.correctAnswer != imageFileNameTwo){
                    //Log.d("intersect", "Intersected2")
                    isGameOver = true
                    //hitWrongAnswer()
                    hitWrongAnswer(imageFileNameTwo)
                }
                else{
                    currentGameScore++
                    crctAns = true
                    hitCorrectAnswer(imageFileNameTwo)
                }
            }
            /*else{
                Log.d("intersect", "else")
            }*/
            //Log.d("intersect", "img:1=: $imageFileNameOne")
            //Log.d("intersect", "img:2=: $imageFileNameTwo")
        }
        //this method creates an alert box to show the score and two buttons that restart or quit the game respectively
        private fun hitWrongAnswer(theHit:String) {
            //play this sound when answer is wrong
            wrongAnsAudio.start()
            //set default position of the car
            car.translationX = 0f
            car.translationY = 100f
            //reset question
            indxCrntQstn = 0
            setGame()
            //val parentView = car.parent as ViewGroup
            //parentView.removeView(car)
            //creating and showing Alert Box
            val alertCorrectAnswer = AlertDialog.Builder(context)
            alertCorrectAnswer.setTitle("Wrong Answer")
                .setMessage("You hit: "+ ((theHit)?.uppercase()) +"\n\n SCORE: $currentGameScore")
                .setPositiveButton("Retry!") { _, _ ->
                    //reset game
                    //parentView.addView(car)
                    currentGameScore = 0
                    isGameOver = false
                }
                .setNegativeButton("Quit") { _, _ ->
                    //take back to the home screen
                    navController.navigate(R.id.action_playScreenFragment_to_mainScreenFragment)
                }
                .show()
        }
        private fun hitCorrectAnswer(theHit: String) {
            //play this sound when answer is correct
            correctAnsAudio.start()
            //indxCrntQstn++
            //setGame()
            //set default position of the car
            car.translationX = 0f
            car.translationY = 100f
            //val parentView = car.parent as ViewGroup
            //parentView.removeView(car)
            //creating and showing Alert Box
            val alertWrongAnswer = AlertDialog.Builder(context)
            alertWrongAnswer.setTitle("Correct Answer")
                .setMessage("You hit: "+ ((theHit)?.uppercase()) +"\n\n SCORE: $currentGameScore")
                .setPositiveButton("Continue") { _, _ ->
                    //parentView.addView(car)
                    //increment to the next question in the list
                    indxCrntQstn++
                    //update the screen with new question if any otherwise show the end screen when all questions answered correctly
                    if (indxCrntQstn < questionAnswers.questions.size) {
                        setGame()
                        crctAns = false
                    } else {
                        //stop the game and show the End Screen
                        crctAns = true
                        navController.navigate(R.id.action_playScreenFragment_to_endScreenFragment)

                    }

                }
                .setNegativeButton("Quit") { _, _ ->
                    //stop the game and take to the home screen
                    crctAns = false
                    navController.navigate(R.id.action_playScreenFragment_to_mainScreenFragment)
                }
                .show()
        }


    }


}