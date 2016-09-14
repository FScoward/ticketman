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

  // TODO: http://scalikejdbc.org/documentation/configuration.html
  DBs.setup(ConnectionPool.DEFAULT_NAME)

  def save(artist: Artist) = {
    DB localTx { implicit s =>
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
