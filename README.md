# DynamicWeather #

**No where near done.**

Basic Weather System to link a City's Weather Conditions to a Minecraft Server

* Using https://visualcrossing.com/ Weather API
* Very Customizable Configuration File
* Body Temperatures able to make players die to heat exhaustion or freezing.

## Config ##

*WARNING*: Check that you have put an api-key and signed up to visualcrossing.com to let the plugin run!

```
# DynamicWeather Configuration File

  api-key: "" # Signup to visualcrossing.com and paste your api-key here
  weather-address: "Auckland" # Pick the city you would like to match with
  weather-worldname: "world" # World that will take effect

  use-true-weather: true # Make it rain/clear
  use-true-temperature: true  # Make player freeze/overheat to death if not wearing enough or too much armor
  use-true-time: false # DayTime will be equal to your timezone instead of minecraft's one

```

## Commands ##

`/dynamicweather reload`

Reload the configuration file & Weather


## Permissions ##

`dynamicweather.commands` - Lets players reload the server configuration file!

