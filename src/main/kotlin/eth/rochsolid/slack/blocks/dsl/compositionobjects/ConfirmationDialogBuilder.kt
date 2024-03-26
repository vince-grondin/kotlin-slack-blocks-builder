package eth.rochsolid.slack.blocks.dsl.compositionobjects

import eth.rochsolid.slack.blocks.models.compositionobjects.ConfirmationDialog

/**
 * [ConfirmationDialog] builder.
 */
class ConfirmationDialogBuilder {
    private lateinit var confirm: PlainTextBuilder
    private lateinit var deny: PlainTextBuilder
    private lateinit var text: PlainTextBuilder
    private lateinit var title: PlainTextBuilder

    private var style: ConfirmationDialog.Style? = null

    fun build(): ConfirmationDialog = ConfirmationDialog(
        confirm = confirm.build(),
        deny = deny.build(),
        text = text.build(),
        title = title.build(),
        style = style
    )

    fun confirm(text: String, fn: PlainTextBuilder.() -> Unit = {}) = apply {
        this.confirm = PlainTextBuilder(text).apply(fn)
    }

    fun dangerStyle() {
        style = ConfirmationDialog.Style.DANGER
    }

    fun deny(text: String, fn: PlainTextBuilder.() -> Unit = {}) = apply {
        this.deny = PlainTextBuilder(text).apply(fn)
    }

    fun primaryStyle() {
        style = ConfirmationDialog.Style.PRIMARY
    }

    fun text(text: String, fn: PlainTextBuilder.() -> Unit = {}) = apply {
        this.text = PlainTextBuilder(text).apply(fn)
    }

    fun title(text: String, fn: PlainTextBuilder.() -> Unit = {}) = apply {
        this.title = PlainTextBuilder(text).apply(fn)
    }
}
