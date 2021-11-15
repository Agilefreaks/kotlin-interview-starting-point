import java.lang.Exception


class CoffeeFinder()
{
    private var userLocation: Coordinates? = null
    private var fileUrl: String? = null
    private var coffeeLocations: MutableList<CoffeShop>? = null
    private val dataReader = Data()

    fun listen()
    {
        // Reading input
        var x: Double? = null
        var y: Double? = null

        var readInput = true
        while ( readInput )
        {
            readInput = false
            readLine()!!.split(' ').mapIndexed { index, s ->
                try
                {
                    when(index)
                    {
                        0 -> x = s.toDouble()
                        1 -> y = s.toDouble()
                        2 -> fileUrl = s
                    }
                }
                catch (ex: Exception)
                {
                    readInput = true
                    println("Incorrect input. Input should be in the following format: <x coordinate> <y coordinate> <shop data url>' \n" +
                            "Example: 47.6 -122.4 coffee_shops.csv")
                    return@mapIndexed
                }
            }

            if ( readInput )
                continue

            userLocation = Coordinates(x!!, y!!)

            // Loading data
            coffeeLocations = dataReader.getData(fileUrl!!)

            if ( coffeeLocations == null )
            {
                readInput = true
                println("Couldn't load any data from $fileUrl")
            }
        }

        // Calculating Distances
        // List of pairs of CoffeeLocation and Distance to that location
        val locationWithDistance = mutableListOf<Pair<CoffeShop, Double>>()

        for ( location in coffeeLocations!!)
        {
            val distance = userLocation!!.distanceToTarget(location.coordinates)
            locationWithDistance.add(Pair(location, distance))
        }

        locationWithDistance.sortBy { it.second }
        for ( i in 0 until 3 ) {
            println("${locationWithDistance[i].first.name}, ${locationWithDistance[i].second}")
        }
    }
}