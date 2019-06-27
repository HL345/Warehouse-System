import request from '@/plugin/axios'
import qs from 'qs'

export function Fetch (data) {
  return request({
    url: '/table/fetch',
    method: 'post',
    data: qs.stringify(data)
  })
}

export function Add (data) {
  return request({
    url: '/table/add',
    method: 'post',
    data: qs.stringify(data)
  })
}

export function Remove (data) {
  return request({
    url: '/table/remove',
    method: 'post',
    data: qs.stringify(data)
  })
}

export function Search (data) {
  return request({
    url: '/table/search',
    method: 'post',
    data: qs.stringify(data)
  })
}
