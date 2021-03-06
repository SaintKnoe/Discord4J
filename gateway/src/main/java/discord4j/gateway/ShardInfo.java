/*
 * This file is part of Discord4J.
 *
 * Discord4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Discord4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Discord4J. If not, see <http://www.gnu.org/licenses/>.
 */

package discord4j.gateway;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * A container to express a shard index and count.
 */
public class ShardInfo {

    private final int index;
    private final int count;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ShardInfo(@JsonProperty("index") int index, @JsonProperty("count") int count) {
        this.index = index;
        this.count = count;
    }

    /**
     * Return the shard index represented by this {@link ShardInfo}.
     *
     * @return the shard number (0-based)
     */
    public int getIndex() {
        return index;
    }

    /**
     * Return the shard count represented by this {@link ShardInfo}.
     *
     * @return the number of shards
     */
    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShardInfo shardInfo = (ShardInfo) o;
        return index == shardInfo.index &&
                count == shardInfo.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, count);
    }

    /**
     * Return a string form of this {@link ShardInfo} using the following pattern: {@code index,count}
     *
     * @return a formatted string representing this object
     */
    public String format() {
        return index + "," + count;
    }

    @Override
    public String toString() {
        return "ShardInfo{" +
                "index=" + index +
                ", count=" + count +
                '}';
    }
}
