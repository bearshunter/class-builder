param(
  [switch]$NoCache,
  [switch]$FollowLogs
)

$ErrorActionPreference = 'Stop'

$scriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
Set-Location $scriptDir

Write-Host "==> Gradle: clean + bootJar"
& .\gradlew clean bootJar

$jar = Get-ChildItem -Path "$scriptDir\build\libs" -Filter *.jar -ErrorAction Stop | Select-Object -First 1
if (-not $jar) {
  Write-Error "Jar not found in build/libs."
  exit 1
}

Write-Host "==> Docker: build app"
$buildArgs = @("build")
if ($NoCache) { $buildArgs += "--no-cache" }
$buildArgs += "app"
docker compose @buildArgs

Write-Host "==> Docker: up app"
docker compose up -d app

if ($FollowLogs) {
  docker compose logs -f app
} else {
  Write-Host " use 'docker compose logs -f app' for logs"
}
