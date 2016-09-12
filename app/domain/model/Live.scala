package domain.model

import org.joda.time.DateTime

/**
 * Created by Fumiyasu on 2016/09/12.
 */
case class LiveId(id: Long)
case class Live(
    liveId: LiveId = LiveId(0L),
    name: String,
    eventDate: EventDate,
    place: Place,
    groups: Seq[GroupId],
    artistId: ArtistId
) {
  def addGroup(groupId: GroupId): Live = this.copy(groups = groups :+ groupId)
}
case class EventDate(start: DateTime, end: DateTime)
