package fhj.swengb.assignments.ttt.dkandlhofer

import java.net.URL
import java.util.ResourceBundle
import javafx.application.Application
import javafx.fxml.{FXML, FXMLLoader, Initializable}
import javafx.scene.control.{Label, Button}
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage

/**
  * Implement here your TicTacToe JavaFX App.
  */
object TicTacToeApp{

  def main(args: Array[String]) {

    Application.launch(classOf[TicTacToeApp], args: _*)

    val mh: Map[TMove, Player] = Map(
      TopLeft -> PlayerA,
      TopCenter -> PlayerA,
      TopRight -> PlayerB,
      MiddleLeft -> PlayerA,
      MiddleCenter -> PlayerB,
      MiddleRight -> PlayerA,
      BottomLeft -> PlayerB,
      BottomCenter -> PlayerA,
      BottomRight -> PlayerB

    )
    println(TicTacToe.apply(mh).asString())

    val mh2: Map[TMove, Player] = Map()
    println(TicTacToe.apply(mh2).turn(TopCenter, PlayerA).asString())
    val x = TicTacToe.apply(mh2).turn(TopCenter, PlayerA).turn(BottomCenter,PlayerB).turn(MiddleRight,PlayerB)
    println(x.asString())


    val all = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9).combinations(5).toList.toSeq
    val z = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9)


  }
}

class TicTacToeApp extends Application {

  val Fxml = "/fhj/swengb/assignments/ttt/TicTacToeApp.fxml"
  val Css = "/fhj/swengb/assignments/ttt/TicTacToeApp.css"

  def FxmlLoader(fxml:String): FXMLLoader = {
    new FXMLLoader(getClass.getResource(fxml))
  }

  override def start(stage: Stage): Unit =
    try {
      stage.setTitle("TicTacToe")
      setSkin(stage, Fxml, Css)
      stage.show()
      stage.setMinWidth(stage.getWidth)
      stage.setMinHeight(stage.getHeight)
    }

  def setSkin(stage:Stage, fxml:String, css:String): Boolean = {
    val scene = new Scene(FxmlLoader(fxml).load[Parent])
    stage.setScene(scene)
    stage.getScene.getStylesheets.clear()
    stage.getScene.getStylesheets.add(css)
  }
}

class TicTacToeController extends Initializable {
  var ttt = TicTacToe()
  var xWins = 0
  var oWins = 0

  @FXML var BtnTopLeft: Button = _
  @FXML var BtnTopCenter: Button = _
  @FXML var BtnTopRight: Button = _
  @FXML var BtnMiddleLeft: Button = _
  @FXML var BtnMiddleCenter: Button = _
  @FXML var BtnMiddleRight: Button = _
  @FXML var BtnBottomLeft: Button = _
  @FXML var BtnBottomCenter: Button = _
  @FXML var BtnBottomRight: Button = _

  @FXML var LblInfo: Label = _
  @FXML var LblMoves: Label = _
  @FXML var LblX: Label = _
  @FXML var LblO: Label = _

  @FXML var BtnNewGame: Button = _
  @FXML var BtnNewGameCpu: Button = _

  override def initialize(location: URL, resources: ResourceBundle): Unit = {

  }

  def setMove(btn: Button, m: TMove): Unit = {
    if(ttt.remainingMoves.contains(m) && !ttt.gameOver) {
      if(ttt.nextPlayer == PlayerA) btn.setText("X") else btn.setText("O")
      ttt = ttt.turn(m, ttt.nextPlayer)
    }
  }

  def newGame(): Unit = {
    ttt = TicTacToe(Map(), PlayerA)
    val btns = Seq(BtnTopLeft, BtnTopCenter, BtnTopRight, BtnMiddleLeft, BtnMiddleCenter, BtnMiddleRight, BtnBottomLeft, BtnBottomCenter, BtnBottomRight)
    for(btn <- btns) btn.setText("")
    LblMoves.setText("")
  }

  @FXML def onTopLeft(): Unit = setMove(BtnTopLeft, TopLeft)
  @FXML def onTopCenter(): Unit = setMove(BtnTopCenter, TopCenter)
  @FXML def onTopRight(): Unit = setMove(BtnTopRight, TopRight)
  @FXML def onMiddleLeft(): Unit = setMove(BtnMiddleLeft, MiddleLeft)
  @FXML def onMiddleCenter(): Unit = setMove(BtnMiddleCenter, MiddleCenter)
  @FXML def onMiddleRight(): Unit = setMove(BtnMiddleRight, MiddleRight)
  @FXML def onBottomLeft(): Unit = setMove(BtnBottomLeft, BottomLeft)
  @FXML def onBottomCenter(): Unit = setMove(BtnBottomCenter, BottomCenter)
  @FXML def onBottomRight(): Unit = setMove(BtnBottomRight, BottomRight)

  @FXML def onNewGame(): Unit = newGame()

}