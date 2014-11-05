package net.hauers.algo

import spock.lang.*

class SorterSpec extends Specification {

  def "Sorter sorts"() {

    given: "A list"
    def list = [3, 2, 1]

    when: "Calling qsort with the list"
    Sorter.qsort(list)

    then: "The list is sorted"
    (0..list.size-1).every{list[it] < list[it+1]}
  }

  def "Partial sorter sorts"() {

    given: "A list"
    def list = [3, 2, 7, 5, 6, 5, 8, 0, 3, 4, 9]

    when: "Calling qsort with the list"
    Sorter.qsort(list, 2, 6)

    then: "The list is partially sorted"
    list == [3, 2, 5, 5, 6, 7, 8, 0, 3, 4, 9]
  }  

  def "Swap swaps"() {
    given:
    def list = [1, 2, 3, 4]

    when:
    Sorter.swap(list, 1, 3)

    then:
    list == [1, 4, 3, 2]
  }
}
