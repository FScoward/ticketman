package infrastructure

import domain.model.Place
import scalikejdbc._
import scalikejdbc.config._

/**
 * Created by Fumiyasu on 2016/09/15.
 */
object PlaceRepository extends SQLSyntaxSupport[Place] {
  def apply(place: ResultName[Place])(rs: WrappedResultSet): Place = new Place(prefecture = rs.get(place.prefecture), address = rs.get(place.address), placeName = rs.get(place.placeName))

  override val tableName = "PLACES"
  override val columns = Seq("place_name", "address", "prefecture")

  def save(place: Place) = {
    DB localTx { implicit s =>
      withSQL {
        insert.into(PlaceRepository).columns(
          column.placeName,
          column.address,
          column.prefecture
        ).values(
          place.placeName,
          place.address,
          place.prefecture
        )
      }.update().apply()
    }
  }

}
