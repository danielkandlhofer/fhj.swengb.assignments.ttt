package fhj.swengb.assignments.ttt.dkandlhofer

import java.net.URL
import java.util.ResourceBundle
import javafx.application.Application
import javafx.event.EventHandler
import javafx.fxml.{FXML, Initializable, FXMLLoader}
import javafx.scene.control.{Button, Label}
import javafx.scene.effect.DropShadow
import javafx.scene.input.MouseEvent
import javafx.scene.layout.{Pane, AnchorPane, BorderPane}
import javafx.scene.shape.Line
import javafx.scene.{Scene, Parent}
import javafx.stage.Stage


import scala.util.control.NonFatal

/**
  * Implement here your TicTacToe JavaFX App.
  */

object TicTacToeApp {
  def main(args: Array[String]) {
    Application.launch(classOf[TicTacToeApp], args: _*)
  }
}

class TicTacToeApp extends javafx.application.Application {

  val Fxml = "/fhj/swengb/assignments/ttt/TicTacToeApp.fxml"

  val loader = new FXMLLoader(getClass.getResource(Fxml))

  override def start(stage: Stage): Unit = try {
    stage.setTitle("Tree assignment")
    loader.load[Parent]() // side effect
    val scene = new Scene(loader.getRoot[Parent])
    stage.setScene(scene)
    stage.show()
  }
  catch {
    case NonFatal(e) => {
      e.printStackTrace()
    }
  }

}


class TicTacToeAppController extends Initializable {

  @FXML var pane: Pane = _
  @FXML var topleft: Label=_
  @FXML var topcenter: Label=_
  @FXML var topright: Label=_
  @FXML var middleleftt: Label=_
  @FXML var middlecenter: Label=_
  @FXML var middleright: Label=_
  @FXML var bottomleft: Label=_
  @FXML var bottomcenter: Label=_
  @FXML var bottomright: Label=_
  @FXML var l_playera: Label=_
  @FXML var l_playerb: Label=_
  @FXML var l_winner: Label=_
  @FXML var buttonstart: Button=_





  override def initialize(location: URL, resources: ResourceBundle): Unit = {
    topleft.setText("x")
    buttonstart
  }

}