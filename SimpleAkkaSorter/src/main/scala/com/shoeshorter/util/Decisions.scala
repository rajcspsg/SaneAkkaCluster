package com.shoesorter.util

import com.shoesorter.domain.Domain._
import com.shoesorter.messages.Messages._

object Decisions {
    def whereShouldContainerGo(junction: Junction, container: Container): Go = {
        Thread.sleep(5) // just to simulate resource hunger
        val seed = util.Random.nextInt(10000)
        Go(s"CVR_${junction.id}_$seed")
    }
}