package tasks

import kotlin.math.max
import kotlin.math.min

/**
 * Problem - https://leetcode.com/problems/container-with-most-water
 */
class Task11 {
    fun maxArea(height: IntArray): Int {
        var l = 0
        var r = height.size - 1
        var area = 0
        while (l != r) {
            area = max(area, min(height[l], height[r]) * (r - l))
            if (height[l] > height[r]) {r -= 1}
            else { l += 1 }
        }
        return area
    }
}