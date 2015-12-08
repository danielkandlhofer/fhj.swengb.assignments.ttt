package fhj.swengb.assignments.ttt.dkandlhofer

import scala.collection.Set

/**
  * models the different moves the game allows
  *
  * each move is made by either player a or player b.
  */
sealed trait TMove {
  def idx: Int
}

case object TopLeft extends TMove {
  override def idx: Int = 0
}

case object TopCenter extends TMove {
  override def idx: Int = 1
}

case object TopRight extends TMove {
  override def idx: Int = 2
}

case object MiddleLeft extends TMove {
  override def idx: Int = 3
}

case object MiddleCenter extends TMove {
  override def idx: Int = 4
}

case object MiddleRight extends TMove {
  override def idx: Int = 5
}

case object BottomLeft extends TMove {
  override def idx: Int = 6
}

case object BottomCenter extends TMove {
  override def idx: Int = 7
}

case object BottomRight extends TMove {
  override def idx: Int = 8
}


/**
  * for a tic tac toe game, there are two players, player A and player B
  */
sealed trait Player

case object PlayerA extends Player

case object PlayerB extends Player

object TicTacToe {

  def main(args:Array[String]):Unit = {

    var gameBoard = List.fill[Char](3,3)(' ')

    def makeRow(row: List[Char]) {
      var left = "|" + " " + row(0) + " |"
      var middle = " " + row(1) + " |"
      var right = " " + row(2) + " " + "|"
      println(left.concat(middle).concat(right))
    }

    def render() {
     // clearScreen
      val divider = "|---|---|---|"
      println(divider)
      makeRow(gameBoard(0))
      println(divider)
      makeRow(gameBoard(1))
      println(divider)
      makeRow(gameBoard(2))
      println(divider)
    }

    def clearScreen = (1 to 30).foreach(_ => println("\n"))

    render()
  }
  /**
    * creates an empty tic tac toe game
    * @return
    */
  def apply(): TicTacToe = ???

  /**
    * For a given tic tac toe game, this function applies all moves to the game.
    * The first element of the sequence is also the first move.
    *
    * @param t
    * @param moves
    * @return
    */
  def play(t: TicTacToe, moves: Seq[TMove]): TicTacToe = ???

  /**
    * creates all possible games.
    * @return
    */
  def mkGames(): Map[Seq[TMove], TicTacToe] = ???
}
  //Map(Seq(TopLeft,TopCenter,TopRight)->TicTacToe),Map(Seq(MiddleLeft,MiddleCenter,MiddleRight)->TicTacToe),Seq(BottomLeft,BottomCenter,BottomRight),Seq(TopLeft,MiddleCenter,BottomRight),Seq(TopRight,MiddleCenter,BottomLeft))

case class TicTacToe(moveHistory: Map[TMove, Player],
                     nextPlayer: Player = PlayerA) {

  /**
    * outputs a representation of the tic tac toe like this:
    *
    * |---|---|---|
    * | x | o | x |
    * |---|---|---|
    * | o | x | x |
    * |---|---|---|
    * | x | o | o |
    * |---|---|---|
    *
    *
    * @return
    */
  def asString(): String = {
    val divide = "|---|---|---|"
    val first = "| x | o | x |"
    divide
    val middle="| o | x | x |"
    divide
    val last = "| x | o | o |"
    divide
  }

  /**
    * is true if the game is over.
    *
    * The game is over if either of a player wins or there is a draw.
    */
  val gameOver : Boolean = ???

  /**
    * the moves which are still to be played on this tic tac toe.
    */
  val remainingMoves: Set[TMove] = ???

  /**
    * given a tic tac toe game, this function returns all
    * games which can be derived by making the next turn. that means one of the
    * possible turns is taken and added to the set.
    */
  lazy val nextGames: Set[TicTacToe] = ???

  /**
    * Either there is no winner, or PlayerA or PlayerB won the game.
    *
    * The set of moves contains all moves which contributed to the result.
    */
  def winner: Option[(Player, Set[TMove])] = ???

  /**
    * returns a copy of the current game, but with the move applied to the tic tac toe game.
    *
    * @param move to be played
    * @param player the player
    * @return
    */
  def turn(move: TMove, player: Player): TicTacToe = ???

}


