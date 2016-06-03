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
 * Stores the document's vertical and horizontal resolution
 * as well as information on how to display dimensions in the UI.
 */
@Chunked
final class ResolutionInfoBlock {
    static final int ID = 0x03ED;

    @Chunk
    int horizontalResolution;
    @Chunk(byteCount = 2)
    ResolutionUnit horizontalUnit;
    @Chunk(byteCount = 2)
    DisplayUnit widthUnit;

    @Chunk
    int verticalResolution;
    @Chunk(byteCount = 2)
    ResolutionUnit verticalUnit;
    @Chunk(byteCount = 2)
    DisplayUnit heightUnit;
}
