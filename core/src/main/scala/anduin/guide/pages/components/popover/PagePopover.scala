package anduin.guide.pages.components.popover

import anduin.guide.components._
import anduin.component.button.Button
import anduin.component.popover.Popover
import anduin.guide.app.main.Pages
import anduin.guide.components.SimpleState
import anduin.mcro.Source
import anduin.style.Style
import japgolly.scalajs.react.vdom.html_<^._

object PagePopover {

  def render(ctl: Pages.Ctl): VdomElement = {
    <.div(
      Toc(headings = Source.getTocHeadings)(),
      <.header(
        Style.margin.bottom32,
        Header(title = "Popover", obj = Some(Popover))()
      ),
      ExampleRich(Source.annotate({
        val p = Popover(
          renderTarget = (toggle, _) => {
            Button(onClick = toggle)("show")
          },
          renderContent = _ => {
            SimpleState.Bool(
              initialValue = false,
              render = (value, onChange) => {
                <.div(
                  Button(onClick = onChange(!value))("a"),
                  if (!value) "a" else "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                )
              }
            )()
          }
        )()
        <.div(p)
      }))()
    )
  }
}
