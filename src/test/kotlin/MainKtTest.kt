import org.junit.Assert.assertEquals
import org.junit.Test

internal class MainKtTest {
    private val testMain: Main = Main()

    @Test
    fun `test sum of two numbers`() {
        val expectedResult = 42
        assertEquals(expectedResult, testMain.sumOfTwoNumbers(40, 2))
    }
}