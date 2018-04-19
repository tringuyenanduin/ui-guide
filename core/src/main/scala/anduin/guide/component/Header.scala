package anduin.guide.component

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import anduin.component.util.ComponentUtils
import anduin.style.Style

final case class Header(
  title: String,
  description: String
) {
  def apply(): VdomElement = {
    Header.component(this)
  }
}

object Header {

  private final val ComponentName = ComponentUtils.name(this)

  private case class Backend(scope: BackendScope[Header, _]) {
    def render(props: Header): VdomElement = {
      <.div(
        Style.border.bottom.borderWidth.px2.borderColor.gray2,
        <.h1(Style.margin.bottom32, props.title),
        <.p(Style.margin.bottom32, props.description)
      )
    }
  }

  private val component = ScalaComponent
    .builder[Header](ComponentName)
    .stateless
    .renderBackend[Backend]
    .build
}
