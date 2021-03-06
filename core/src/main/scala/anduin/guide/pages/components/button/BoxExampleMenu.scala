// Copyright (C) 2014-2019 Anduin Transactions Inc.

package anduin.guide.pages.components.button

import anduin.component.button.Button
import anduin.component.icon.Icon
import anduin.component.menu.{Menu, MenuDivider, MenuItem}
import anduin.component.popover.Popover
import anduin.component.portal.PositionBottomLeft
import anduin.guide.components.ExampleSimple

// scalastyle:off underscore.import
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
// scalastyle:on underscore.import

final case class BoxExampleMenu() {
  def apply(): VdomElement = BoxExampleMenu.component(this)
}

object BoxExampleMenu {

  private type Props = BoxExampleMenu

  private def renderContent(close: Callback): VdomElement = {
    val Item = MenuItem(onClick = close)
    Menu()(
      Item("Open"),
      Item("Open With…"),
      MenuDivider()(),
      Item("Get Info"),
      Item("Compress"),
      Item("Copy"),
      MenuDivider()(),
      Item.copy(color = MenuItem.ColorDanger)("Delete"),
    )
  }

  private def renderTarget(toggle: Callback, isSelected: Boolean): VdomElement = {
    Button(
      style = Button.Style.Ghost(
        icon = Some(Icon.Glyph.EllipsisHorizontal),
        isSelected = isSelected
      ),
      onClick = toggle
    )()
  }

  private def render(props: Props): VdomElement = {
    ExampleSimple()(
      Popover(
        renderTarget = renderTarget,
        renderContent = renderContent,
        position = PositionBottomLeft
      )()
    )
  }

  private val component = ScalaComponent
    .builder[Props](this.getClass.getSimpleName)
    .stateless
    .render_P(render)
    .build
}
