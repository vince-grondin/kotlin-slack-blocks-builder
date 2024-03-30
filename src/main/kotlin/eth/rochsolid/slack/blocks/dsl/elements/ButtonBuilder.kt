package eth.rochsolid.slack.blocks.dsl.elements

import eth.rochsolid.slack.blocks.dsl.BlockDslMarker
import eth.rochsolid.slack.blocks.dsl.compositionobjects.ConfirmationDialogBuilder
import eth.rochsolid.slack.blocks.dsl.compositionobjects.PlainTextBuilder
import eth.rochsolid.slack.blocks.models.elements.ActionableElement
import eth.rochsolid.slack.blocks.models.elements.Button
import java.net.URL

@BlockDslMarker
class ButtonBuilder(text: String) : ElementBuilder<Button>() {
    private var confirm: ConfirmationDialogBuilder? = null
    private var focusOnLoad: Boolean? = null
    private var style: Button.Style? = null
    private var text = PlainTextBuilder(text)

    var accessibilityLabel: String? = null
    var url: String? = null
    var value: String? = null

    override fun build(): Button = Button(
        accessibilityLabel = accessibilityLabel,
        actionID = actionID?.let(ActionableElement::ActionID),
        confirm = confirm?.build(),
        focusOnLoad = focusOnLoad,
        style = style,
        text = text.build(),
        url = url?.let(::URL),
        value = value
    )

    fun confirm(fn: ConfirmationDialogBuilder.() -> Unit) = apply {
        confirm = ConfirmationDialogBuilder().apply(fn)
    }

    fun dangerStyle() = apply {
        style = Button.Style.DANGER
    }

    fun focusOnLoad(focusOnLoad: Boolean? = true) = apply {
        this.focusOnLoad = focusOnLoad
    }

    fun text(text: String, fn: PlainTextBuilder.() -> Unit = {}) = apply {
        this.text = PlainTextBuilder(text).apply(fn)
    }

    fun primaryStyle() = apply {
        style = Button.Style.PRIMARY
    }
}
