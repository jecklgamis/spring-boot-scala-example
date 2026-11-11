#!/usr/bin/env bash
# Runs the resonate load tests under perf-tests/. The app must already be running
# (e.g. `make run`) and resonate installed (brew install jecklgamis/tap/resonate).
set -euo pipefail
cd "$(dirname "$0")"

command -v resonate >/dev/null || { echo "resonate not found in PATH" >&2; exit 1; }

for scenario in perf-tests/*.yaml; do
  name="$(basename "$scenario" .yaml)"
  echo "==> Running $scenario"
  resonate run "$scenario" \
    --html-report "perf-tests/$name-report.html" \
    --json-report "perf-tests/$name-report.json" \
    --results-file "perf-tests/$name-results.jsonl"
done
