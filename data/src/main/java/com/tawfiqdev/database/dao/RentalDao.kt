package com.tawfiqdev.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tawfiqdev.database.entity.RentalEntity
import com.tawfiqdev.database.entity.RentalStatus
import kotlinx.coroutines.flow.Flow

@Dao
interface RentalDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRental(rental: RentalEntity)

    @Query("""
        SELECT * FROM rentals
        WHERE reservationId = :reservationId
        LIMIT 1
    """)
    suspend fun getRentalByReservation(reservationId: String): RentalEntity?

    @Query("""
        SELECT * FROM rentals
        WHERE status = 'ACTIVE'
        LIMIT 1
    """)
    fun getActiveRental(): Flow<RentalEntity?>

    @Query("""
        UPDATE rentals
        SET status = :status,
            checkOutDate = :checkOutDate,
            endMileage = :endMileage
        WHERE rentalId = :rentalId
    """)
    suspend fun closeRental(
        rentalId: String,
        status: RentalStatus,
        checkOutDate: Long,
        endMileage: Int
    )
}