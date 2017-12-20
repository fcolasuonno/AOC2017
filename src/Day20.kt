object Day20 {
    data class Particle(var px: Int, var py: Int, var pz: Int, var vx: Int, var vy: Int, var vz: Int, val ax: Int, val ay: Int, val az: Int) {
        fun tick() {
            vx += ax
            vy += ay
            vz += az

            px += vx
            py += vy
            pz += vz
        }
    }

    fun part1(input: List<String>): Int {
        val particles = input.map {
            val values =
                    "p=<([^,]+),([^,]+),([^>]+)>, v=<([^,]+),([^,]+),([^>]+)>, a=<([^,]+),([^,]+),([^>]+)>"
                            .toRegex().matchEntire(it)!!.groupValues.drop(1).map { it.trim().toInt() }
            Particle(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8])
        }

        return particles.withIndex().groupBy { Math.abs(it.value.ax) + Math.abs(it.value.ay) + Math.abs(it.value.az) }
                .minBy { it.key }!!.value
                .groupBy { Math.abs(it.value.vx) + Math.abs(it.value.vy) + Math.abs(it.value.vz) }
                .minBy { it.key }!!.value
                .groupBy { Math.abs(it.value.px) + Math.abs(it.value.py) + Math.abs(it.value.pz) }
                .minBy { it.key }!!.value.single().index
    }

    fun part2(input: List<String>): Int {
        var particles = input.map {
            val values =
                    "p=<([^,]+),([^,]+),([^>]+)>, v=<([^,]+),([^,]+),([^>]+)>, a=<([^,]+),([^,]+),([^>]+)>"
                            .toRegex().matchEntire(it)!!.groupValues.drop(1).map { it.trim().toInt() }
            Particle(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8])
        }
        for (i in 0..1000) {
            particles.forEach { it.tick() }
            particles = particles.groupBy { Triple(it.px, it.py, it.pz) }.filter { it.value.size == 1 }.values.map { it.single() }
        }
        return particles.count()
    }
}