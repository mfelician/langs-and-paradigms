package statemachine.scala.model

import statemachine.scala.model.TerminalSymbol._
import statemachine.scala.model.StateMachineState._

/**
 * Contains the production rules for the implemented state machine.
 */
object ProductionRules {

  /**
   * Result of a step in the state machine.
   *
   * @param newState
   *                 the new state in which we have to step if the terminal symbol is allowed in the current state,
   *                 None otherwise
   * @param terminalProcessed
   *                 <code>true</code> if we successfully processed the terminal symbol,
   *                 <code>false</code> otherwise, eg. when we applied a chain rule
   *
   */
  case class RuleResult(newState: Option[StateMachineState], terminalProcessed : Boolean = true)

  val FAIL = RuleResult(None, false)

  // Production rules here:
  def applyRule(state : StateMachineState)(symbol : TerminalSymbol) : RuleResult = {
    state match {
      case START_SIGNED => symbol match {
        case SIGN => RuleResult(Some(START_UNSIGNED))
        case DIGIT | ZERO | POINT => RuleResult(Some(START_UNSIGNED), false)
        case _ => FAIL
      }
      case START_UNSIGNED => symbol match {
        case POINT => RuleResult(Some(ILLEGAL_STATE_0))
        case ZERO => RuleResult(Some(LEGAL_STATE_2))
        case DIGIT => RuleResult(Some(LEGAL_STATE_4))
        case SIGN => FAIL
      }
      case ILLEGAL_STATE_0 => symbol match {
        case DIGIT => RuleResult(Some(LEGAL_STATE_1))
        case _ => FAIL
      }
      case LEGAL_STATE_1 => symbol match {
        case DIGIT => RuleResult(Some(LEGAL_STATE_1))
        case _ => FAIL
      }
      case LEGAL_STATE_2 => symbol match {
        case POINT => RuleResult(Some(LEGAL_STATE_3))
        case _ => FAIL
      }
      case LEGAL_STATE_3 => symbol match {
        case DIGIT => RuleResult(Some(LEGAL_STATE_3))
        case _ => FAIL
      }
      case LEGAL_STATE_4 => symbol match {
        case DIGIT => RuleResult(Some(LEGAL_STATE_4))
        case POINT => RuleResult(Some(LEGAL_STATE_5))
        case _ => FAIL
      }
      case LEGAL_STATE_5 => symbol match {
        case DIGIT => RuleResult(Some(LEGAL_STATE_5))
        case _ => FAIL
      }
    }
  }
}
