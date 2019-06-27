import request from '@/plugin/axios'
import qs from 'qs'

export function GetUsetInfo (data) {
  return request({
    url: '/user/info',
    method: 'post',
    data: qs.stringify(data)
  })
}
