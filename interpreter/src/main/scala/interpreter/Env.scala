package scala.meta
package interpreter

import internal.interpreter.Environment
import internal.representations._

/**
 * Created by rutz on 05/10/15.
 */

trait Env {
  def +(name: Term.Name, value: Any): Env
}

class EnvImpl(val slots: Map[Term.Name, Any] = Map[Term.Name, Any]()) extends Env {
  def this(e: Environment) = this(e.get.flatMap {
      case (Local(name), Literal(l)) => List(name -> l)
      case _ => Nil
    }.toMap[Term.Name, Any])
  def +(name: Term.Name, value: Any): Env = new EnvImpl(slots + (name -> value))
}

object Env {
  def apply(): Env = new EnvImpl()
  def apply(keyval: (Term.Name, Any)*): Env = new EnvImpl(keyval.toMap)
}