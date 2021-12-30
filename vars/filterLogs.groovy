#!/usr/bin/env groovy
import org.apache.commons.lang.StringUtils

def call(String filter_string, int occurence){
  def logs = currentBuild.rawBuild.getLog(1000).join('\n')
  int count = StringUtils.countMatches(logs, filter_string);
  if(count > occurence -1){
    currentBuild.result='UNSTABLE'
  }
}
