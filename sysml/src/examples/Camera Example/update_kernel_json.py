import json
import os

kernel_path = "/Users/jamesyuan/Developer/Learning Repos (On Git)/SysML-v2-Release/.pixi/envs/default/share/jupyter/kernels/sysml/kernel.json"
with open(kernel_path, "r") as f:
    data = json.load(f)

bin_dir = "/Users/jamesyuan/Developer/Learning Repos (On Git)/SysML-v2-Release/.pixi/envs/default/bin"
jvm_dir = "/Users/jamesyuan/Developer/Learning Repos (On Git)/SysML-v2-Release/.pixi/envs/default/lib/jvm/bin"

if "env" not in data:
    data["env"] = {}

# Set PATH to include pixi bin dirs
data["env"]["PATH"] = f"{bin_dir}:{jvm_dir}:/usr/bin:/bin:/usr/sbin:/sbin"

# Change 'java' to absolute path
data["argv"][0] = f"{jvm_dir}/java"

with open(kernel_path, "w") as f:
    json.dump(data, f, indent=4)
