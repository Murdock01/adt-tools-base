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
#ifndef NETWORK_NETWORK_SAMPLER_H_
#define NETWORK_NETWORK_SAMPLER_H_

#include "proto/network_profiler.pb.h"

#include <string>
#include <vector>

namespace profiler {

// Abstract network data collector.
class NetworkSampler {
 public:
  virtual ~NetworkSampler() = default;

  // Run data collection and put result into the given proto.
  virtual void GetData(profiler::proto::NetworkProfilerData *data) = 0;

  // Returns the app uid that is read from the given pid_status_file if present,
  // -1 otherwise.
  static int GetUid(const std::string &pid_status_file);

  // Returns true if uid is present in given pid_status_file and assigned to the
  // parameter uid string, false otherwise. The returned string is verified that
  // it contains zero to nine only.
  static bool GetUidString(const std::string &pid_status_file,
                           std::string *uid);
};

}  // namespace profiler

#endif // NETWORK_NETWORK_SAMPLER_H_
