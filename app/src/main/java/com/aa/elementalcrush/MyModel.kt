package com.aa.elementalcrush

//model data
class MyModel {
    //array list that stores each discovery item
    val discovery = ArrayList<DiscoveryItem>()
    //adding all discovering items to the array list at initialization
    init {
        discovery.add(DiscoveryItem("Sodium", 11, "Alkali metals", "Sodium is a very reactive soft metal.", "Sodium is used in streetlights to produce yellow light as well as being a component in many compounds like table salt, soda ash, borax, and baking soda.",R.drawable.sodium))
        discovery.add(DiscoveryItem("Sulfur", 16, "Reactive non-metals", "Sulfur is a brittle yellow solid.", "Sulfur is used in gunpowder and other pyrotechnics, rubber manufacturing, and as an insecticide, fungicide, and fumigant. It can also be used to treat skin diseases, however, its prime use is in compound separation.",R.drawable.sulfur))
        discovery.add(DiscoveryItem("Mercury", 80, "Transition metals", "Mercury is a liquid metal and is toxic.", "Mercury is used to making thermometers, barometers, electrical switches, and other instruments. It is often used in streetlights and fluorescent lamps and in the chemical industry as a catalyst.",R.drawable.mercury))
        discovery.add(DiscoveryItem("Hydrogen", 1, "Reactive non-metals", "Hydrogen is an explosive gas and also the lightest element.", "Hydrogen makes up about 90 percent of atoms in the entire universe. The chemical is used heavily as both a gas and liquid fuel. Hydrogen was used as a main fuel for the Space Shuttle program by NASA, as well as currently being used heavily by the petroleum and manufacturing industries.",R.drawable.hydrogen))
        discovery.add(DiscoveryItem("Gold", 79, "Transition metals", "Gold is the most malleable element, and is a dense non-tarnishing colored metal.", "Gold is one of the most coveted metals in the world, because it can be easily shaped and sculpted, conducts electricity well, and does not tarnish. Aside from its use in coinage and jewelry, it is used in gears for watches, artificial limb joints, and electrical connectors. Gold nanoparticles are used as industrial catalysts.",R.drawable.gold))
        discovery.add(DiscoveryItem("Silver", 47, "Transition metals", "Silver is a soft shiny metal that is the best electrical conductor.", "Silver is used in jewelry and tableware. It is the best reflector of visible light, although it does tarnish. It is used in soldering and brazing compounds as well as batteries. Silver paints are used for making printed circuits. Silver also has antibacterial properties and recently silver nanoparticles have been used in clothing to prevent bacteria from growing and creating unpleasant odors.",R.drawable.silver))
        discovery.add(DiscoveryItem("Cobalt", 27, "Transition metals", "Cobalt is a hard metal and is magnetic.", "Cobalt is used mostly as a cancer treatment and in radiotherapy. Cobalt metal is sometimes used in electroplating because of its attractive appearance, hardness, and resistance to corrosion.",R.drawable.cobalt))
        discovery.add(DiscoveryItem("Copper", 29, "Transition metals", "Copper is a colored metal that conducts heat and electricity well.", "Copper is one of the best conductors of electricity, which leads to its use in electronics and motors. The metal is also very thermally conductive, so it is used in radiators, A/C units, and heating systems.",R.drawable.copper))
        discovery.add(DiscoveryItem("Lithium", 3, "Alkali metals", "Under standard conditions, Lithium is the lightest metal and is soft and reactive.", "Lithium is known most commonly to be used in batteries. It is also used in aluminum alloys, to make cookware more durable, and most surprisingly, in psychiatric medicines as a mood stabilizer.",R.drawable.lithium))
        discovery.add(DiscoveryItem("Lutetium", 71, "Lanthanides", "Lutetium is a soft metal and is the densest and hardest rare earth metal.", "Lutetium is very rare and high in price. When refined, it can be used in the petroleum cracking process. There are few other commercial applications.",R.drawable.lutetium))
        discovery.add(DiscoveryItem("Livermorium", 116, "Unknown properties", "Livermorium is a radioactive element that is short-lived.", "No uses outside research.",R.drawable.livermorium))
        discovery.add(DiscoveryItem("Lawrencium", 103, "Actinides", "Lawrencium is a radioactive element that is short-lived.", "No uses outside research.",R.drawable.lawrencium))
        discovery.add(DiscoveryItem("Chromium", 24, "Transition metals", "Chromium is a hard shiny metal.", "Chromium is used in stainless steel as well as in the chrome plating process. Various chromium compounds are known for their vivid colors.",R.drawable.chromium))
        discovery.add(DiscoveryItem("Carbon", 6, "Reactive non-metals", "There are a number of pure forms of this element including graphite, diamond, fullerenes and graphene. The nano-forms, fullerenes, and graphene, appear as black or dark brown, soot-like powders.", "Carbon is unique among the elements in its ability to form strongly bonded chains, sealed off by hydrogen atoms. These hydrocarbons are mostly used as fuels and as a feedstock for the production of polymers, fibres, paints, solvents, and plastics, etc. Impure carbon in the form of charcoal (from wood) and coke (from coal) is used in metal smelting.",R.drawable.carbon))
        discovery.add(DiscoveryItem("Titanium", 22, "Transition metals", "Titanium is the strongest lightweight metal and is heat-resistant.", "Titanium is an incredibly strong metal used in alloys with aluminum, iron, and other metals. This strong metal is used in the aerospace industry as well as engines partly because of its ability to maintain its strength in thermal extremes.",R.drawable.titanium))
        discovery.add(DiscoveryItem("Tin", 50, "Post-transition metals", "Tin is a non-corroding soft metal.", "Tin has the ability to be polished to a high degree and is not corrodible. It is mainly used to coat other metals or as an alloy in solder and pewter. Niobium-tin magnets are known for their superconducting abilities.",R.drawable.tin))
        discovery.add(DiscoveryItem("Boron", 5, "Metalloids", "Boron is a powdery, black solid.", "Boron is used in pyrotechnics. When burned, it gives off a green color in the flame. More common uses are in boric acid and borax. You can find boron in antiseptics, washing chemicals, ceramic glazes, and eye drops.",R.drawable.boron))
        discovery.add(DiscoveryItem("Bromine", 35, "Reactive non-metals", "Bromine is a dark red liquid.", "Bromine is used as a flame-retarder in plastics and electronics. It can also be used to purify and disinfect water, leading to its uses in swimming pools and hot tubs.",R.drawable.bromine))
        discovery.add(DiscoveryItem("Tungsten", 74, "Transition metals", "Tungsten is the highest-melting-point dense metal.", "Tungsten has the highest melting point of all metals, leading to its use as filaments in incandescent bulbs. It is also used in steel to impart strength.",R.drawable.tungsten))
        discovery.add(DiscoveryItem("Tennessine", 117, "Unknown properties", "Tennessine is a radioactive element that is short-lived.", "No uses outside research.",R.drawable.tennessine))
        discovery.add(DiscoveryItem("Iron", 26, "Transition metals", "Iron is a medium-hard metal and has magnetic properties.", "Iron's prime use is in making steel. When steel is combined with chromium, it produces stainless steel which is resistant to corrosion.",R.drawable.iron))
        discovery.add(DiscoveryItem("Fluorine", 9, "Reactive non-metals", "Fluorine is a yellowish poison gas and the most reactive element.", "Fluorine is a common additive to drinking water and is used as a cleaning agent in toothpaste. Fluorine is also used in many solvents and high-temperature plastics, such as Teflon and Gore-Tex®.",R.drawable.fluorine))
    }
}