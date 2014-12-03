import spock.lang.*

class TopCoderSpec extends spock.lang.Specification {

	def "The Spock Framework is working properly"() {
		expect: "The trivial test runs as expected"
		true
	}
  
  @IgnoreRest
  def "AliceGame works"() {
    expect:
    retval == new AliceGame().findMinimumValue(x,y)
    
    where:
    x | y | retval
    9 | 9 | -1
    8 | 17 | 2
    17 | 8 | 3
    0 | 0 | 0
    500000 |    500000 |294
    2000001| 999997999999 | 3
    1_000_000_000_000 | 0 | 1_000_000
  } 
}
