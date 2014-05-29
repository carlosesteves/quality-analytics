#!/bin/sh

# map A to live and remove link to stage
cf map-route quality-analytics-live-a cf1.test.i.springer.com -n live
cf unmap-route quality-analytics-live-a cf1.test.i.springer.com -n stage

# map B to stage and remove link to live
cf map-route quality-analytics-live-b cf1.test.i.springer.com -n stage
cf unmap-route quality-analytics-live-b cf1.test.i.springer.com -n live
