package com.nilutopia.mylibrary

import org.junit.Assert
import org.junit.Test
import kotlin.math.pow
import kotlin.math.sqrt

class MyLibraryKtTest {

    private fun calculateDistance(x1: Double, y1: Double, x2: Double, y2: Double): Double {
        return sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2))
    }

    @Test
    fun `Distance between identical points`() {
        val distance = calculateDistance(1.0, 1.0, 1.0, 1.0)
        Assert.assertEquals(0.0, distance, 0.0001)
    }

    @Test
    fun `Horizontal distance`() {
        val distance = calculateDistance(1.0, 2.0, 5.0, 2.0)
        Assert.assertEquals(4.0, distance, 0.0001)
        val distance2 = calculateDistance(-1.0, 2.0, 5.0, 2.0)
        Assert.assertEquals(6.0, distance2, 0.0001)
        val distance3 = calculateDistance(-5.0, 2.0, -1.0, 2.0)
        Assert.assertEquals(4.0, distance3, 0.0001)
    }

    @Test
    fun `Vertical distance`() {
        val distance = calculateDistance(1.0, 2.0, 1.0, 6.0)
        Assert.assertEquals(4.0, distance, 0.0001)
        val distance2 = calculateDistance(1.0, -2.0, 1.0, 6.0)
        Assert.assertEquals(8.0, distance2, 0.0001)
        val distance3 = calculateDistance(1.0, -6.0, 1.0, -2.0)
        Assert.assertEquals(4.0, distance3, 0.0001)
    }

    @Test
    fun `Diagonal distance`() {
        val distance = calculateDistance(0.0, 0.0, 3.0, 4.0)
        Assert.assertEquals(5.0, distance, 0.0001)
        val distance2 = calculateDistance(1.0, 1.0, 4.0, 5.0)
        Assert.assertEquals(5.0, distance2, 0.0001)
    }

    @Test
    fun `Negative coordinates`() {
        val distance = calculateDistance(-1.0, -2.0, 3.0, 4.0)
        Assert.assertEquals(7.2111, distance, 0.0001)
        val distance2 = calculateDistance(1.0, 2.0, -3.0, -4.0)
        Assert.assertEquals(7.2111, distance2, 0.0001)
        val distance3 = calculateDistance(-1.0, 2.0, 3.0, -4.0)
        Assert.assertEquals(7.2111, distance3, 0.0001)
        val distance4 = calculateDistance(1.0, -2.0, -3.0, 4.0)
        Assert.assertEquals(7.2111, distance4, 0.0001)
    }

    @Test
    fun `Zero coordinates`() {
        val distance = calculateDistance(0.0, 0.0, 1.0, 1.0)
        Assert.assertEquals(1.4142, distance, 0.0001)
        val distance2 = calculateDistance(0.0, 1.0, 1.0, 0.0)
        Assert.assertEquals(1.4142, distance2, 0.0001)
        val distance3 = calculateDistance(1.0, 0.0, 0.0, 1.0)
        Assert.assertEquals(1.4142, distance3, 0.0001)
    }

    @Test
    fun `Large coordinates`() {
        val distance = calculateDistance(1e10, 1e10, 1e10 + 3.0, 1e10 + 4.0)
        Assert.assertEquals(5.0, distance, 0.0001)
    }

    @Test
    fun `Decimal coordinates`() {
        val distance = calculateDistance(1.5, 2.5, 3.5, 4.5)
        Assert.assertEquals(2.8284, distance, 0.0001)
        val distance2 = calculateDistance(1.25, 2.75, 3.75, 4.25)
        Assert.assertEquals(2.9154, distance2, 0.0001)
    }

    @Test
    fun `Mixed positive and negative coordinates`() {
        val distance = calculateDistance(1.0, 2.0, -3.0, -4.0)
        Assert.assertEquals(7.2111, distance, 0.0001)
        val distance2 = calculateDistance(-1.0, -2.0, 3.0, 4.0)
        Assert.assertEquals(7.2111, distance2, 0.0001)
    }

    @Test
    fun `X Axis zero point`() {
        val distance = calculateDistance(0.0, 1.0, 3.0, 4.0)
        Assert.assertEquals(4.2426, distance, 0.0001)
        val distance2 = calculateDistance(1.0, 0.0, 4.0, 3.0)
        Assert.assertEquals(4.2426, distance2, 0.0001)
    }

    @Test
    fun `Y Axis zero point`() {
        val distance = calculateDistance(1.0, 0.0, 4.0, 3.0)
        Assert.assertEquals(4.2426, distance, 0.0001)
        val distance2 = calculateDistance(0.0, 1.0, 3.0, 4.0)
        Assert.assertEquals(4.2426, distance2, 0.0001)
    }

    @Test
    fun `Near zero difference in coordinates`() {
        val distance = calculateDistance(1.0, 1.0, 1.0000001, 1.0000001)
        Assert.assertEquals(0.0000, distance, 0.0001)
        val distance2 = calculateDistance(1.0, 1.0, 1.000001, 1.000001)
        Assert.assertEquals(0.0000, distance2, 0.0001)
    }

    @Test
    fun `Extreme values for double`() {
        val distance = calculateDistance(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)
        Assert.assertEquals(0.0, distance, 0.0001)
        val distance2 = calculateDistance(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE)
        Assert.assertEquals(0.0, distance2, 0.0001)
    }

}