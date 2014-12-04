import spock.lang.*

class TopCoderSpec extends spock.lang.Specification {

	def "The Spock Framework is working properly"() {
		expect: "The trivial test runs as expected"
		true
	}
  
  @IgnoreRest
  def "SRM "() {
    when:
    def z = x
    
    then: 
    z == retval
    
    where:
    x | y | retval
    0 | 0 | 0  
  }
  
  /*
   * Got 325.72 points out of 1000
   */
  def "SRM 465 DIV 2 1000: Archibald Weird Times"() {
    when:
    def z = new WeirdTimes().hourValues(minuteValues as int[], K);
    
    then:
    z == retval as int[]
    
    where:
    minuteValues  | K | retval
    [22,11,33]   | 3 | [0,1,3]  
    [10]  | 2 | [1] 
    [2,1] | 20 | [0, 20] 
    [1,2] | 20 | [0, 19]
    [45, 12, 0, 3, 2, 7, 4, 9, 23, 6, 17, 33] | 12345 | [0, 1, 2, 2, 3, 3, 4, 5, 12, 13, 18, 18]
    [43, 58] | 318 | [-1]
    [25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 
      15, 15, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1] | 1 | [-1]
      
  }
  
  /*
   * Got 156.97 points out of 500. That's pretty shit
   */
  def "SRM 465 DIV 2 500: Little Petya folding puzzle"() {
    when:
    def x = new BoardFolding().howMany(N, M, compressedPaper)
    
    then:
    x == retval
    
    where:
    N | M | compressedPaper|retval
    2 | 2 | ["1", "3"] as String[] |1
    2 | 7 | ["@@", "@@"] as String[] | 84
    4 | 4 | ["6", "9", "9", "6"] as String[] | 9
    6 | 1 | ["0", "2", "6", "@", "4", "A"] as String[] | 6
    3 | 3 | [ "0", "2", "0" ] as String[] | 1
  }
  
  /*
   * 
   */
  def "SRM 465 DIV 2 250: Archibald neighboring pairs"() {
    expect:
    true // int NumberNeighbours().numPairs(int[] numbers)
  }
  
  /*
   * 
   */
  def "SRM 465 DIV 2 500: Archibald turret placement"() {
    expect:
    true // long TurretPlacement().count(int[] x, int[] y)
  }
  
  /*
   * 
   */
  def "SRM 639 DIV 1 250: Alice Game"() {
    expect:
    retval == new AliceGame().findMinimumValue(x,y)
    
    where:
    x | y | retval
    9 | 9 | -1
    8 | 17 | 2
    17 | 8 | 3
    0 | 0 | 0
    500_000 | 500_000 |294
    2_000_001| 999_997_999_999 | 3
    1_000_000_000_000 | 0 | 1_000_000
  } 
}
