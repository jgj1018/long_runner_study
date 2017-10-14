package prototype

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class PrototypeTest {

    @Test
    fun cacheTest(){
        ShapeCache.loadCache()

        val clonedShape = ShapeCache.getShape("1")
        val clonedShape2 = ShapeCache.getShape("2")
        val clonedShape3 = ShapeCache.getShape("3")

        val realShape1 = ShapeCache.shapeMap.get("1") as Shape
        val realShape2 = ShapeCache.shapeMap.get("2") as Shape
        val realShape3 = ShapeCache.shapeMap.get("3") as Shape


        assertEquals("1", clonedShape.id)
        assertEquals("2", clonedShape2.id)
        assertEquals("3", clonedShape3.id)
        assertNotEquals(clonedShape, realShape1)
        assertNotEquals(clonedShape2, realShape2)
        assertNotEquals(clonedShape3, realShape3)

        assertEquals(clonedShape.javaClass.kotlin,
                realShape1.javaClass.kotlin)
        assertEquals(clonedShape2.javaClass.kotlin,
                realShape2.javaClass.kotlin)
        assertEquals(clonedShape2.javaClass.kotlin,
                realShape2.javaClass.kotlin)

        assertFalse(clonedShape == realShape1)
        assertFalse(clonedShape2 == realShape2)
        assertFalse(clonedShape3== realShape3)
    }
}