package eth.rochsolid.slack.blocks.models.compositionobjects

import kotlinx.serialization.SerialName

/**
 * Defines when a [Text.PlainText] plain-text input element will return a
 * [block_actions](https://api.slack.com/reference/interaction-payloads/block-actions) interaction payload.
 *
 * Example:
 * ```json
 * {
 *     "type": "input",
 *     "dispatch_action": true,
 *     "element": {
 *         "type": "plain_text_input",
 *         "multiline": true,
 *         "dispatch_action_config": {
 *             "trigger_actions_on": [
 *                 "on_character_entered"
 *             ]
 *         }
 *     },
 *     "label": {
 *         "type": "plain_text",
 *         "text": "This is a multiline plain-text input",
 *         "emoji": true
 *     }
 * }
 * ```
 */
data class DispatchActionConfiguration(
    /**
     * A list of interaction types that you would like to receive a
     * [block_actions payload](https://api.slack.com/reference/interaction-payloads/block-actions) for.
     */
    @SerialName("trigger_actions_on")
    val triggerActionsOn: List<InteractionType>?
) {
    enum class InteractionType {
        /**
         * Payload is dispatched when a character is entered (or removed) in the input.
         */
        @SerialName("on_character_entered")
        ON_CHARACTER_ENTERED,

        /**
         * Payload is dispatched when user presses the enter key while the input is in focus.
         * Hint text will appear underneath the input explaining to the user to press enter to submit.
         */
        @SerialName("on_enter_pressed")
        ON_ENTER_PRESSED,
    }
}
