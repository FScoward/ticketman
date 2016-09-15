package infrastructure

import domain.model.{ Artist, ArtistId }
import scalikejdbc._
import scalikejdbc.config._

/**
 * Created by Fumiyasu on 2016/09/13.
 */
object ArtistRepository extends SQLSyntaxSupport[Artist] {
  def apply(artist: ResultName[Artist])(rs: WrappedResultSet): Artist = new Artist(ArtistId(rs.get(artist.artistId)), artistName = rs.get(artist.artistName))
  override val tableName = "ARTISTS"
  override val columns = Seq("artist_id", "artist_name")

  def save(artist: Artist) = {
    DB localTx { implicit session =>
      withSQL {
        insert.into(ArtistRepository).columns(
          column.artistId,
          column.artistName
        ).values(
          artist.artistId.id,
          artist.artistName
        )
      }.update().apply()
    }
  }

}
