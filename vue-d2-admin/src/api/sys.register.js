import request from '@/plugin/axios'
import qs from 'qs'

export function AccountRegister (data) {
  return request({
    url: '/register',
    method: 'post',
    data: qs.stringify(data)
  })
}
