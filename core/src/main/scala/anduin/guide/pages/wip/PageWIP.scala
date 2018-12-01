package anduin.guide.pages.wip

import anduin.guide.components._
import anduin.component.button.{Button, ButtonStyle}
import anduin.guide.app.main.Pages
import anduin.mcro.Source
import anduin.style.Style
import japgolly.scalajs.react.vdom.html_<^._

object PageWIP {
  def render(ctl: Pages.Ctl): VdomElement = {
    <.div(
      Header(title = "Working in Progress")(),
      Toc(headings = Source.getTocHeadings)(),
      ExampleRich(Source.annotate({
        <.div("a")
      }))(),
      ExampleRich(Source.annotate({
        <.div(
          "a",
          "b"
        )
      }))(),
      ExampleRich(Source.annotate({
        <.div("a", "b")
      }))(),
      ExampleRich(Source.annotate({
        Button(
          color = ButtonStyle.ColorBlue
        )("a")
      }))(),
      ExampleRich(Source.annotate({
        Button()("a")
      }))(),
      ExampleRich(Source.annotate({
        val button = Button()("a")
        <.div(button)
      }))(),
      ExampleRich(Source.annotate({
        val foo = "a"
        <.div(foo)
      }))(),
      ExampleRich(Source.annotate({
        <.div(Button()("a"))
      }))(),
      ExampleRich(Source.annotate({
        <.div(
          Button()("a")
        )
      }))(),
    )
  }
}
