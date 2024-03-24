package eth.rochsolid.slack.blocks.models.compositionobjects

import kotlinx.serialization.SerialName

/**
 * Defines a dialog that adds a confirmation step to interactive elements.
 * An object that defines a dialog that provides a confirmation step to any interactive element.
 * This dialog will ask the user to confirm their action by offering a confirm and deny buttons.
 * [View API docs](https://api.slack.com/reference/block-kit/composition-objects#confirm)
 *
 * [Example](https://api.slack.com/reference/block-kit/composition-objects#confirm__example)([view this in Block Kit Builder](https://api.slack.com/tools/block-kit-builder?mode=message&blocks=%5B%7B%22type%22%3A%22section%22%2C%22text%22%3A%7B%22type%22%3A%22mrkdwn%22%2C%22text%22%3A%22You%20have%20a%20new%20request%3A%5Cn*%3CfakeLink.toEmployeeProfile.com%7CFred%20Enriquez%20-%20New%20device%20request%3E*%22%7D%7D%2C%7B%22type%22%3A%22section%22%2C%22fields%22%3A%5B%7B%22type%22%3A%22mrkdwn%22%2C%22text%22%3A%22*Type%3A*%5CnComputer%20(laptop)%22%7D%2C%7B%22type%22%3A%22mrkdwn%22%2C%22text%22%3A%22*When%3A*%5CnSubmitted%20Aut%2010%22%7D%2C%7B%22type%22%3A%22mrkdwn%22%2C%22text%22%3A%22*Last%20Update%3A*%5CnMar%2010%2C%202015%20(3%20years%2C%205%20months)%22%7D%2C%7B%22type%22%3A%22mrkdwn%22%2C%22text%22%3A%22*Reason%3A*%5CnAll%20vowel%20keys%20aren%27t%20working.%22%7D%2C%7B%22type%22%3A%22mrkdwn%22%2C%22text%22%3A%22*Specs%3A*%5Cn%5C%22Cheetah%20Pro%2015%5C%22%20-%20Fast%2C%20really%20fast%5C%22%22%7D%5D%7D%2C%7B%22type%22%3A%22actions%22%2C%22elements%22%3A%5B%7B%22type%22%3A%22button%22%2C%22text%22%3A%7B%22type%22%3A%22plain_text%22%2C%22emoji%22%3Atrue%2C%22text%22%3A%22Approve%22%7D%2C%22confirm%22%3A%7B%22title%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22Are%20you%20sure%3F%22%7D%2C%22text%22%3A%7B%22type%22%3A%22mrkdwn%22%2C%22text%22%3A%22Wouldn%27t%20you%20prefer%20a%20good%20game%20of%20_chess_%3F%22%7D%2C%22confirm%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22Do%20it%22%7D%2C%22deny%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22Stop%2C%20I%27ve%20changed%20my%20mind!%22%7D%7D%2C%22style%22%3A%22primary%22%2C%22value%22%3A%22click_me_123%22%7D%2C%7B%22type%22%3A%22button%22%2C%22text%22%3A%7B%22type%22%3A%22plain_text%22%2C%22emoji%22%3Atrue%2C%22text%22%3A%22Deny%22%7D%2C%22style%22%3A%22danger%22%2C%22value%22%3A%22click_me_123%22%7D%5D%7D%5D))
 * ```json
 * {
 *     "title": {
 *         "type": "plain_text",
 *         "text": "Are you sure?"
 *     },
 *     "text": {
 *         "type": "plain_text",
 *         "text": "Wouldn't you prefer a good game of chess?"
 *     },
 *     "confirm": {
 *         "type": "plain_text",
 *         "text": "Do it"
 *     },
 *     "deny": {
 *         "type": "plain_text",
 *         "text": "Stop, I've changed my mind!"
 *     }
 * }
 * ```
 */
data class ConfirmationDialog(
    /**
     * A [CompositionObject.Text.PlainText] object that defines the dialog's title.
     * Maximum length for this field is 100 characters.
     */
    val title: Text.PlainText,
    /**
     * A [Text.PlainText] object that defines the explanatory text that appears in the confirm
     * dialog.
     * Maximum length for the text in this field is 300 characters.
     */
    val text: Text.PlainText,
    /**
     * A [Text.PlainText] object to define the text of the button that confirms the action.
     * Maximum length for the text in this field is 30 characters.
     */
    val confirm: Text.PlainText,
    /**
     * A [Text.PlainText] object to define the text of the button that cancels the action.
     * Maximum length for the text in this field is 30 characters.
     */
    val deny: Text.PlainText,
    /**
     * Defines the color scheme applied to the [confirm] button.
     * If this field is not provided, the default value will be [Style.PRIMARY].
     */
    val style: Style?
) {
    enum class Style {
        /**
         * A value of danger will display the button with a red background on desktop, or red text on mobile.
         */
        @SerialName("danger")
        DANGER,

        /**
         * A value of primary will display the button with a green background on desktop, or blue text on mobile.
         */
        @SerialName("primary")
        PRIMARY
    }
}
