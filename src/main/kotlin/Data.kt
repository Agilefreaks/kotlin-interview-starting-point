import com.opencsv.CSVReader
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.net.URL


class Data()
{
    private val baseUrl =  "https://raw.githubusercontent.com/Agilefreaks/test_oop/master/"


    fun getData(urlString: String): MutableList<CoffeShop>?
    {
        val url = URL(baseUrl + urlString)

        try
        {
            val buffer = BufferedReader(InputStreamReader(url.openStream()))
            val csvReader = CSVReader(buffer)
            val dataList = mutableListOf<CoffeShop>()

            var line: Array<String>? = csvReader.readNext()
            while (line != null)
            {
                if ( line.size < 3 )
                {
                    line = csvReader.readNext()
                    continue
                }

                try
                {
                    val name = line[0]
                    val x = line[1].toDouble()
                    val y = line[2].toDouble()

                    dataList.add(CoffeShop(name, Coordinates(x, y)))
                }
                catch (ex: Exception)
                {
                    line = csvReader.readNext()
                    continue
                }

                line = csvReader.readNext()
            }

            return if ( dataList.count() == 0 ) null else dataList
        }
        catch (ex: Exception)
        {
            return null
        }
    }
}