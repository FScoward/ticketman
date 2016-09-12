package domain.model

/**
 * Created by Fumiyasu on 2016/09/12.
 */
case class GroupId(id: Long)
case class Group(groupId: GroupId, name: String, liveId: LiveId, owner: Seq[UserId], member: Seq[UserId]) {
  def addMember(userId: UserId) = this.copy(member = member :+ userId)
}
