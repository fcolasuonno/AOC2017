import kotlin.math.abs

object Day20 {
    data class Particle(var p: Day20.Vec3, var v: Day20.Vec3, val a: Day20.Vec3) {
        fun tick() {
            v += a

            p += v
        }
    }

    data class Vec3(var x: Int, var y: Int, var z: Int) {
        operator fun plus(other: Vec3): Vec3 {
            return Vec3(x + other.x, y + other.y, z + other.z)
        }

        fun manhattanDistance(): Int {
            return abs(x) + abs(y) + abs(z)
        }
    }

    fun part1(input: List<String>): Int {
        val particles = input.map {
            "p=<([^,]+),([^,]+),([^>]+)>, v=<([^,]+),([^,]+),([^>]+)>, a=<([^,]+),([^,]+),([^>]+)>"
                    .toRegex().matchEntire(it)!!.groupValues.drop(1).map { it.trim().toInt() }
                    .chunked(3) { Vec3(it[0], it[1], it[2]) }
                    .let { Particle(it[0], it[1], it[2]) }
        }

        return particles.withIndex().groupBy { it.value.a.manhattanDistance() }
                .minBy { it.key }!!.value
                .groupBy { it.value.v.manhattanDistance() }
                .minBy { it.key }!!.value
                .groupBy { it.value.p.manhattanDistance() }
                .minBy { it.key }!!.value.single().index
    }


    fun part2(input: List<String>): Int {
        var particles = input.map {
            "p=<([^,]+),([^,]+),([^>]+)>, v=<([^,]+),([^,]+),([^>]+)>, a=<([^,]+),([^,]+),([^>]+)>"
                    .toRegex().matchEntire(it)!!.groupValues.drop(1).map { it.trim().toInt() }
                    .chunked(3) { Vec3(it[0], it[1], it[2]) }
                    .let { Particle(it[0], it[1], it[2]) }
        }
        for (i in 0..1000) {
            particles.forEach { it.tick() }
            particles = particles.groupBy { it.p }.filterValues { it.size == 1 }.values.map { it.single() }
        }
        return particles.count()
    }
}