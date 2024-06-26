package eth.rochsolid.slack.blocks.models.blocks

import eth.rochsolid.slack.blocks.models.compositionobjects.Text
import eth.rochsolid.slack.blocks.models.elements.Element
import kotlinx.serialization.SerialName


/**
 * Collects information from users via block elements.
 * Read the guides to collecting input in [modals](https://api.slack.com/surfaces/modals#gathering_input) or
 * [in Home tabs](https://api.slack.com/surfaces/app-home#gathering_input) to learn how input blocks pass
 * information to your app.
 * Example:
 * - An input block containing a [CompositionObject.Text.PlainText]) ([view this in Block Kit Builder](https://app.slack.com/block-kit-builder/?_gl=1*dgipho*_gcl_au*MTI4ODM0OTk1NS4xNzExMTc3MTY0#%7B%22title%22:%7B%22type%22:%22plain_text%22,%22text%22:%22Add%20info%20to%20feedback%22,%22emoji%22:true%7D,%22submit%22:%7B%22type%22:%22plain_text%22,%22text%22:%22Save%22,%22emoji%22:true%7D,%22type%22:%22modal%22,%22blocks%22:%5B%7B%22type%22:%22input%22,%22element%22:%7B%22type%22:%22plain_text_input%22%7D,%22label%22:%7B%22type%22:%22plain_text%22,%22text%22:%22Label%22,%22emoji%22:true%7D%7D%5D%7D))
 * ```json
 * {
 *   "type": "input",
 *   "element": {
 *     "type": "plain_text_input"
 *   },
 *   "label": {
 *     "type": "plain_text",
 *     "text": "Label",
 *     "emoji": true
 *   }
 * }
 * ```
 */
data class Input(
    /**
     * A unique identifier for a block. If not specified, a block_id will be generated by the Slack API.
     * You can use this [blockID] when you receive an interaction payload to identify the source of the action.
     * Maximum length for this field is 255 characters. [blockID] should be unique for each message and each iteration
     * of a message. If a message is updated, use a new [blockID].
     */
    @SerialName("block_id")
    override val blockID: BlockID?,
    /**
     * A label that appears above an input element in the form of a [CompositionObject.Text.PlainText].
     * Maximum length for the text in this field is 2000 characters.
     */
    val label: Text.PlainText,
    /**
     * A [Element]
     */
    val element: Block,
    /**
     * A boolean that indicates whether the use of elements in this block should dispatch
     * a [block_actions](https://api.slack.com/reference/interaction-payloads/block-actions) payload.
     * Defaults to `false`.
     */
    @SerialName("dispatch_action")
    val dispatchAction: Boolean? = false,
    /**
     * An optional hint that appears below an input element in a lighter grey.
     * Maximum length for the text in this field is 2000 characters.
     */
    val hint: Text.PlainText?,
    /**
     * A boolean that indicates whether the input element may be empty when a user submits the modal.
     * Defaults to false.
     */
    val optional: Boolean? = false
) : Block(type = Type.INPUT)
