package com.tawfiqdev.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tawfiqdev.database.entity.ReservationEntity
import com.tawfiqdev.database.entity.ReservationStatus
import kotlinx.coroutines.flow.Flow

@Dao
interface ReservationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReservation(reservation: ReservationEntity)

    @Query("""
        SELECT * FROM reservations
        WHERE userId = :userId
        ORDER BY startDate DESC
    """)
    fun getUserReservations(userId: String): Flow<List<ReservationEntity>>

    @Query("""
        SELECT * FROM reservations
        WHERE reservationId = :reservationId
        LIMIT 1
    """)
    suspend fun getReservationById(reservationId: String): ReservationEntity?

    @Query("""
        UPDATE reservations 
        SET status = :status 
        WHERE reservationId = :reservationId
    """)
    suspend fun updateReservationStatus(
        reservationId: String,
        status: ReservationStatus
    )
}