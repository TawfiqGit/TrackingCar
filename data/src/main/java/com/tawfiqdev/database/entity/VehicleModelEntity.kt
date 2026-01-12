package com.tawfiqdev.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.tawfiqdev.model.VehicleModel

@Entity(tableName = "vehicles_model")
data class VehicleModelEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "marque") val marque: String,
    @ColumnInfo(name = "brand") val brand: String,
    @ColumnInfo(name = "version") val version: String,
    @ColumnInfo(name = "color") val color: String,
    @ColumnInfo(name = "year") val year: Int,
    @ColumnInfo(name = "energy") val energy: String,
    @ColumnInfo(name = "lengthMeters") val lengthMeters: Double?,
    @ColumnInfo(name = "widthMeters") val widthMeters: Double?,
    @ColumnInfo(name = "heightMeters") val heightMeters: Double?,
    @ColumnInfo(name = "wheelbaseMeters") val wheelbaseMeters: Double?,
    @ColumnInfo(name = "weightVadFinKg") val weightVadFinKg: Int?
)