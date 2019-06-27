import request from '@/plugin/axios'
import qs from 'qs'

export function GetUserInfo (data) {
  return request({
    url: '/user/info',
    method: 'post',
    data: qs.stringify(data)
  })
}

export function UpdateUserInfo (data) {
  return request({
    url: '/user/update',
    method: 'post',
    data: qs.stringify(data)
  })
}

export function UpdateUserPass (data) {
  return request({
    url: '/user/pass',
    method: 'post',
    data: qs.stringify(data)
  })
}
