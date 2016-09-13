package domain.model

/**
 * Created by Fumiyasu on 2016/09/12.
 */
case class TicketId(id: Long)
case class Ticket(ticketId: TicketId, ticketHolder: UserId, seatNo: Option[String], ticketStatus: TicketStatus) {
  def updateStatus(ticketStatus: TicketStatus) = this.copy(ticketStatus = ticketStatus)
}

trait TicketStatus
/** 予約 */
case object Reserved extends TicketStatus
/** 落選 */
case object Rejected extends TicketStatus
/** 余り */
case object Surplus extends TicketStatus
/** 割り当て済み */
case object Assigned extends TicketStatus
