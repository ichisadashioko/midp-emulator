#!/usr/bin/env python3
# sudo apt install dos2unix
import os
import subprocess
from subprocess import PIPE


def main():
    completed_process = subprocess.run(
        ['git', 'ls-files'],
        stdout=PIPE,
        stderr=PIPE,
    )

    lines = completed_process.stdout.decode('utf-8').split('\n')

    tracked_files = list(filter(lambda x: len(x) > 0, lines))

    for filepath in tracked_files:
        os.system('dos2unix '+filepath)


if __name__ == '__main__':
    main()
