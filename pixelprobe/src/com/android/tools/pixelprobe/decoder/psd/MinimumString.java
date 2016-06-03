/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.tools.pixelprobe.decoder.psd;

import com.android.tools.chunkio.Chunk;
import com.android.tools.chunkio.Chunked;

/**
 * Helper class to read an ASCII string whose length is
 * stored as a 32 bits unsigned integer. If the length
 * is 0, the string is assumed to have a length of 4 bytes.
 */
@Chunked
final class MinimumString {
    @Chunk(byteCount = 4)
    long length;

    @Chunk(dynamicByteCount = "Math.max(minimumString.length, 4)")
    String value;

    @Override
    public String toString() {
        return value;
    }
}
