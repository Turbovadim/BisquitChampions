package net.turbovadim.bisquitchampions.database

import androidx.room.*

@Dao
interface NoteDao {
    @Query("SELECT * FROM Note")
    fun getAll(): List<Note>

    @Query("SELECT * FROM Note WHERE id=(:id)")
    fun getById(id: Int): Note

    @Query("SELECT * FROM Note ORDER BY id DESC LIMIT 1")
    fun getLast(): Note

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)
}