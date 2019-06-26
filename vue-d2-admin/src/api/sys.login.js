import request from '@/plugin/axios'
import qs from 'qs'

export function AccountLogin (data) {
  return request({
    url: '/login',
    method: 'post',
    data: qs.stringify(data)
  })
}
